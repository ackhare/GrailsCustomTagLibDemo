package grailscustomtaglibdemo

class Person {
    String firstName
    String lastName
    Date dateOfBirth
    Boolean active=true
    static constraints = {
        firstName(blank: false)
        lastName(blank: false)
        dateOfBirth(blank: false)
    }
}
