package littleBrother;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class Monitor {

	static int spaces = 0;
	
	public static void main(String[] args) {
		spaces = 0;
	}
	public void addPress() {
		System.out.println("# of presses: " + spaces);
		spaces += 1;
	}
	public void sendInfo() {
		System.out.println("Sent. Wipe initated.");
		wipe();
	}
	public void wipe() {
		System.out.println("Wiped up.");
		spaces = 0;
	}
	

}
