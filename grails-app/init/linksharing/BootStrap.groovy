import enums.Seriousness
import enums.Visibility

class BootStrap {

    def init = { servletContext ->
        //search for save(flush:true) error
        // version for entry
        //try using version
        if (User.count() == 0) {
            User admin = new User(firstName: 'Mohd', lastName: "Kashif", email: "mohdkashif1108@gmail.com", userName: "mdkshf", password: "123456", isAdmin: true, isActive: true)
            admin.validate()
            admin.save(failOnError: true)
            if (admin.hasErrors()) {
                println 'we are having an error while saving admin or some fields are empty'
            }
            User user = new User(firstName: 'normal', lastName: 'user', email: 'normaluser@gmail.com', userName: 'normal.user', password: '123456', isAdmin: false, isActive: true)
            user.validate()
            if (user.hasErrors()) {
                println 'we are having an error while saving a normal user or some fields are empty'
            }
            user.save()
        }
        User user = User.findByUserName("normal.user")
        def topicCount = Topic.count()
        if (topicCount == 0) {
            Topic topic1 = new Topic(name: 'Groovy', visibility: Visibility.PUBLIC, createdBy: user)
            Subscription subscription = new Subscription(topic: topic1, seriousness: Seriousness.VERY_SERIOUS)
            topic1.addToSubscriptions(subscription)
            user.addToSubscriptions(subscription)
            user.addToTopics(topic1)
            topic1.validate()
            if (topic1.hasErrors()) {
                println 'trouble saving topic1'
            }
            println topic1
            topic1.save()
            Topic topic2 = new Topic(name: 'Grails', visibility: Visibility.PUBLIC, createdBy: user)
            Subscription subscription1 = new Subscription(topic: topic2, user: user, seriousness: Seriousness.VERY_SERIOUS)
            topic2.addToSubscriptions(subscription1)
            user.addToSubscriptions(subscription1)
            user.addToTopics(topic2)
            subscription1.validate()
            if (subscription1.hasErrors()) {
                println 'trouble saving subscription for topic 2'
                println subscription1.errors
            }
            topic2.validate()
            if (topic2.hasErrors()) {
                println 'trouble saving topic2'
            }
            topic2.save()
            Topic topic3 = new Topic(name: 'Java', visibility: Visibility.PRIVATE, createdBy: user)
            Subscription subscription2 = new Subscription(topic: topic3, user: user, seriousness: Seriousness.VERY_SERIOUS)
            topic3.addToSubscriptions(subscription2)
            user.addToSubscriptions(subscription2)
            user.addToTopics(topic3)
            subscription2.validate()
            if (subscription2.hasErrors()) {
                println 'trouble saving subscription for topic 3'
            }
            if (topic3.hasErrors()) {
                println 'trouble saving topic3'
            }
            topic3.save()
            Topic topic4 = new Topic(name: 'Spring Boot', visibility: Visibility.PRIVATE, createdBy: user)
            Subscription subscription3 = new Subscription(topic: topic3, user: user, seriousness: Seriousness.VERY_SERIOUS)
            topic4.addToSubscriptions(subscription3)
            user.addToSubscriptions(subscription3)
            user.addToTopics(topic4)
            subscription3.validate()
            if (subscription3.hasErrors()) {
                println 'trouble saving subscription for topic 4'
            }
            if (topic4.hasErrors()) {
                println 'trouble saving topic4'
            }
            topic4.save()
            Topic topic5 = new Topic(name: 'Gralde', visibility: Visibility.PUBLIC, createdBy: user)
            Subscription subscription4 = new Subscription(topic: topic5, user: user, seriousness: Seriousness.VERY_SERIOUS)
            topic5.addToSubscriptions(subscription4)
            user.addToSubscriptions(subscription4)
            user.addToTopics(topic5)
            subscription4.validate()
            if (subscription4.hasErrors()) {
                println 'trouble saving subscription for topic 5'
            }
            if (topic5.hasErrors()) {
                println 'trouble saving topic5'
            }
            topic5.save()
        }
        Topic topic = user.topics[1]
        if (topic.resources.isEmpty()) {
            DocumentResource documentResource1 = new DocumentResource(filePath: '/abc/xyz', createdBy: topic.createdBy, description: topic.name, topic: topic)
            documentResource1.validate()
            if (documentResource1.hasErrors()) {
                println documentResource1.errors
            }
            documentResource1.save()
            DocumentResource documentResource2 = new DocumentResource(filePath: '/abc/abc/file.txt', createdBy: topic.createdBy, description: topic.name, topic: topic)
            documentResource2.validate()
            if (documentResource2.hasErrors()) {
                println documentResource2.errors
            }
            documentResource2.save()
            LinkResource linkResource1 = new LinkResource(url: 'https://www.google.com/', createdBy: topic.createdBy, description: topic.name, topic: topic)
            linkResource1.validate()
            if (linkResource1.hasErrors()) {
                println linkResource1.errors
            }
            linkResource1.save()
            LinkResource linkResourse2 = new LinkResource(url: 'https://www.instagram.com/', createdBy: topic.createdBy, description: topic.name, topic: topic)
            linkResourse2.validate()
            if (linkResourse2.hasErrors()) {
                println linkResourse2.errors
            }
            linkResourse2.save()
        }
        //change logback.xml to .groovy
    }
        def destroy = {
        }
}