
class userController {
    static defaultAction = "index"
    def index()
    {
        render 'User dashboard'
    }
    def Users()
    {
        List<User> users = User.findAll()
        println users
        render users
    }
}
