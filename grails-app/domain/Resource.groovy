abstract class Resource {
    User createdBy
    String description
    Topic topic
    Set<ResourceRating> ratings
    Set<ReadingItem> readingItems
    Date dateCreated
    Date lastUpdated
    static hasMany = [readingItems : ReadingItem, ratings : ResourceRating]
    static mapping = {
        //difference b/w singletablestrategy and table per hierarchy
        tablePerHierarchy false
    }
}