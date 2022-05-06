
class LoginController {
    def index()
    {
        if (session.user == null)
        {
            render "Failure"
        }
        else
        {
            redirect(controller: "User",action: "index")
            //redirect(url:"http://localhost:8080/helloWorld/user/index")
        }
    }
    def loginHandler()
    {
        if (params.name != null && params.password != null) {
            def users = User.findAllByUserName(params.name)
            User user = users[0]
            if (user == null) {
                flash.error = 'User not found'
                render flash.error
                redirect(url:"http://localhost:8080/helloWorld/login/loginHandler")
            }
            else if (user != null) {
                if (user.isActive) {
                    //def loggedUser = session["loggedUser"]
                    //learn HTTP session and how to create it
                    session.user = user
                    render "Session name is " + session.name
                    //login index action kya hai
                    //redirect(url:)
                }
                else {
                    //Caused by: groovy.lang.MissingMethodException: No signature of method: org.grails.web.servlet.GrailsFlashScope.error() is applicable for argument types: (String) values: [Your account is not active]
                    flash.error = 'Your account is not active'
                    redirect(url:"http://localhost:8080/helloWorld/login/loginHandler")
                }
            }
        }
        else {
            render 'cannot login'
        }
    }
    def logoutAction()
    {
        session.invalidate()
        forward(action: 'index')
    }
}