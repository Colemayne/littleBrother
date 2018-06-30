package littleBrother;
//hi kendall!

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

public class GlobalKeyListener implements NativeKeyListener {
	
	Monitor monitor = new Monitor();
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		if (e.getKeyCode() == NativeKeyEvent.VC_SPACE) {           
		
            try {
			    System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			    Files.write(Paths.get("/home/dev-cbeiler/test.txt"), "Space has been pressed once.\n".getBytes(), StandardOpenOption.APPEND);  
			    monitor.addPress();
		    } catch (IOException ex) {
		
		    }
		}
		
		
		
		 
		   
	}
	
	public void nativeKeyReleased(NativeKeyEvent e) {
		
		//todo
	}
	

	
	public static void main(String[] args) {
		
		Boolean running = true;
		
		GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
		
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);
		
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
			
			System.exit(1);
		}
		
	    
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
