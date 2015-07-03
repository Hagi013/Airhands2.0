
package jp.co.airhands2.welcomehome.controller;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.co.airhands2.welcomehome.application.controller.BaseController;
/*import jp.co.airhands2.welcomehome.helper.Facebook4j;
*/
public class LoginController extends BaseController{


    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getInputLoginId()
    {
        return inputLoginId;
    }

    public void setInputLoginId(String inputLoginId)
    {
        this.inputLoginId = inputLoginId;
    }

    public String getInputPassword()
    {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword)
    {
        this.inputPassword = inputPassword;
    }

    /*public String singIn()
        throws ServletException, IOException
    {
        HttpServletRequest request = getRequest();
        if(inputLoginId != null)
            try
            {
                request.login(inputLoginId, inputPassword);
            }
            catch(ServletException ex)
            {
                addErrorMessage("\u30ED\u30B0\u30A4\u30F3\u3067\u304D\u307E\u305B\u3093", "");
                return null;
            }
        return redirectTo("");
    }*/

/*    public String singInByFacebook(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, FacebookException
    {
        Facebook facebook = facebook4j.getFacebook();
        facebook.getOAuthAppAccessToken();
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/callback");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
        return redirectTo("");
    }

    public String doPost()
        throws ServletException, IOException
    {
        Facebook facebook = facebook4j.getFacebook();
        try
        {
            facebook.postStatusMessage(message);
        }
        catch(FacebookException e)
        {
            throw new ServletException(e);
        }
        return redirectTo("");
    }*/

    private static final long serialVersionUID = 0x5f6f66d3f607ac8cL;
/*    private Facebook4j facebook4j;*/
    private String message;
    private String inputLoginId;
    private String inputPassword;
}
