interface FileSystemNode {
    fun getParent(): FileSystemNode?
    fun getName(): String
    fun getPath(): String
}

abstract class AbstractFileSystemNode(private var name: String) : FileSystemNode {

    var parent: AbstractFileSystemNode? = null

    final override fun getParent(): FileSystemNode? {
        return parent
    }

    override fun getName(): String {
        return name
    }

    final override fun getPath(): String {
        return  "${getParent()?.getPath()?:""}/${getName()}"
    }
}
class Folder(name: String, vararg child_elements: AbstractFileSystemNode) :
    AbstractFileSystemNode(name) {
    private var children = ArrayList<AbstractFileSystemNode>()

    init {
        for (el in child_elements) {
            el.parent = this
            children.add(el)
        }
    }
}

class File(name: String, private var extension: String) : AbstractFileSystemNode(name) {

    override fun getName(): String {
        return "${super.getName()}.$extension"
    }

    fun getExtension(): String{
        return extension
    }
}

fun main(args: Array<String>) {
    val readme = File("readme","md")
    val bashRc = File("","bashrc")
    val user = Folder("User", readme, bashRc)
    val home = Folder("home", user)
    val opt =  Folder("opt")

    println("Readme path: " + readme.getPath())
    println("User folder path: " + user.getPath())
    println("Bashrc name: " + bashRc.getName())
    println("Readme name: " + readme.getName())
    println("Readme extension: " + readme.getExtension())
}