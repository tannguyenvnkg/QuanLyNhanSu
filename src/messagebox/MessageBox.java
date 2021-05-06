/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagebox;

/**
 *
 * @author tanng
 */
public class MessageBox {
    
    private static MessageBox instance;
    private MessageBox(){
    }
    public static MessageBox showMessageBox() {
        if (instance == null) {
            instance = new MessageBox();
        }
        return instance;
    }
    public void showSuccess(String vanban){
        DialogSuccess ds = new DialogSuccess();
        ds.show();
        ds.setlable(vanban);
    }
    public void showError(String vanban){
        DialogError de = new DialogError();
        de.show();
        de.setlable(vanban);
    }
    
}
