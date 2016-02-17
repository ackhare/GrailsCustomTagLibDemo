package grailscustomtaglibdemo

class SimpleTagLib {
//    static defaultEncodeAs = [taglib:'html']
//    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
  def renderList = { attr, body ->
    // reads the 'values' attribute from the attributes list
    def list = attr.values
    // iterates and renders list values
    list.each {
      // uses the implicit 'out' variable to append content to the response
      out << "<span class=\"element\"> ${it} </span> <br/>"
    }
  }



  def justRender = {
    println 'request'
    println request.contextPath
    println params

    def controllerName=params.controller
    def actionName=params.action
      out << "Hello"
    }

  /**
   * @attr times times to iterate
   * @attr iterator the name of the injected 'iterator' variable, default to 'i'
   */
  def iterate = { attrs, body ->
    attrs.times?.toInteger().times { it ->
      // provides the 'i' variable to hold the iteration number
      // or can use the variable name from the 'iterator' attribute

      out << body((attrs.iterator ? attrs.iterator : "i") : it)
    }
  }



  def personLink = {attrs ->
    def person = attrs.person
    def personName = "${person?.firstName} ${person?.lastName}"

    if (person?.active){
      out << link(controller:'person', action:'index'){personName}
    } else {
      out << empName
    }
  }



}
