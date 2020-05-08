package FourthLesson

@Grapes([
        @Grab(group='org.xerial',
                module='sqlite-jdbc',
                version='3.7.2'),
        @GrabConfig(systemClassLoader=true)
])
import groovy.sql.Sql

def dataBase = [url:'jdbc:mysql://localhost:3306/Lab5?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC',
          user:'root', password:'8951fdsa', driver:'org.sqlite.JDBC']

def sqlInstance = Sql.newInstance(dataBase.url,dataBase.user,dataBase.password,dataBase.driver)

ArrayList<Integer> listID = new ArrayList<>()
sqlInstance.eachRow("select * from Item") {
    listID.add(it.id)
    println("id=${it.id}, name= ${it.Title}")
}

println(listID.size())