/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab9a;

import javax.swing.JLabel;

/**
 *
 * @author crbrehm
 */
public class StopwatchThread extends Thread {

    private JLabel label;
    private boolean exit;
    
    public StopwatchThread (JLabel label) {
        this.label = label;
    }
	
	public void run() 
	{
                exit = false;
		while(!exit) {
                    try {
                        Thread.sleep(1000);
                        label.setText(String.valueOf(Integer.parseInt(label.getText()) + 1));
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }
		}
	}
        
        public void end() {
            exit = true;
        }
}
