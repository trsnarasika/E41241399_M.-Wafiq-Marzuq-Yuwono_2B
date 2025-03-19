/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyek_michiko_creative;

/**
 *
 * @author wafiq
 */

    import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.function.Consumer;

public class RFIDReader {
    private SerialPort serialPort;
    private BufferedReader input;
    private OutputStream output;
    private static final String PORT_NAMES[] = { 
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    private Consumer<String> listener;

    public RFIDReader() {
        initialize();
    }

    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }

        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void readData() {
        String inputLine;
        try {
            while ((inputLine = input.readLine()) != null) {
                final String line = inputLine.trim(); // Fix for lambda expression scope
                java.awt.EventQueue.invokeLater(() -> listener.accept(line));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void setListener(Consumer<String> listener) {
        this.listener = listener;
    }
}


