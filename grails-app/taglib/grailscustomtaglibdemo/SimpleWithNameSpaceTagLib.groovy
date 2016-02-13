package grailscustomtaglibdemo

class SimpleWithNameSpaceTagLib {
    static namespace = "simple"
  def justRender = {
      out << "Hello"
    }




  def empList = {attrs ->
    def persons = attrs.persons
    def mb = new groovy.xml.MarkupBuilder(out)
    mb.table{
      tr{
        th{ mb.yield "Person Name" }
        th{ mb.yield "Date of Birth" }
      }
      persons.each{emp ->
        tr{
          td{mb.yield "${persons.firstName} ${persons.lastName}"}
          td{mb.yield "${persons.dateOfBirth}"}
        }
      }
    }
  }
}
