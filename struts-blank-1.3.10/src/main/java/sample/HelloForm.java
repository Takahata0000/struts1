package sample;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class HelloForm extends ActionForm{
	private String name;
	private String kumi;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;};
	
	public String getKumi() {return kumi;}
	public void setKumi(String kumi) {this.kumi = kumi;};
	
	// バリデーション処理
    public ActionErrors validate(
            ActionMapping mapping,
            HttpServletRequest request) {

            ActionErrors errors = new ActionErrors();

            // Name must be entered
            if ((name == null) || (name.length() < 1)) {
                errors.add("name", new ActionMessage("errors.name.required"));
            }

            // Secret Phrase must be entered
            if ((kumi == null) || (kumi.length() < 1)) {
                errors.add("kumi", new ActionMessage("errors.kumi.required"));
            }

            return (errors);

        }
}
