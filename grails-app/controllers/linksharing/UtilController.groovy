class UtilController {
    def index() {
        //artifacts mai logger kaise use krenge
        ch.qos.logback.classic.Logger log = org.slf4j.LoggerFactory.getLogger("com.linksharing.UtilController") as ch.qos.logback.classic.Logger
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("com.linksharing.UtilController")
        render "my name is " + session.name
        log.info("WE are in utilController")
        logger.info("THis is SLF4J")
    }
}