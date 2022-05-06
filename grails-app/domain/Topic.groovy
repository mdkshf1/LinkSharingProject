import enums.Seriousness
import enums.Visibility
class Topic {
    // add uniqueness per topic for every user
    String name
    Visibility visibility
    User createdBy
    Date dateCreated
    Date lastUpdated
    Set<Subscription> subscriptions
    Set<Resource> resources
    static hasMany = [subscriptions : Subscription, resources : Resource]
    static belongsTo = [createdBy: User]
    static constraints = {
        name blank : false, nullable : false
        visibility nullable : false, blank : false
        createdBy nullable : false, blank : false
    }
    def afterInsert()
    {
        Topic.withNewSession {
            Subscription subscription = new Subscription(user: createdBy,seriousness: Seriousness.VERY_SERIOUS,topic: this)
            createdBy.addToSubscriptions(subscription)
        }
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", createdBy=" + createdBy.fullName +
                '}';
    }
    static mapping = {
        sort "name"
    }
}