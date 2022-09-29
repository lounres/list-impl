class LinkedList<T> {
    
    class Node<T>(var value: T, var nexNode: Node<T>? = null)
    
    private var head: Node<T>? = null
    
    private var last: Node<T>? = null
    
    private var size: Int = 0
    
    fun count(): Int {
        return size
    }
       
    fun insert(index: Int, obj: T) {
        TODO("Not yet implemented")
    }
    fun removeAt(index: Int) {
        TODO("Not yet implemented")
    }
    operator fun get(index: Int): T {
        TODO("Not yet implemented")
    }
    operator fun set(index: Int, obj: T) {
        TODO("Not yet implemented")
    }
    fun find(obj: T): Int {
        TODO("Not yet implemented")
    }
    
    fun clear() {
        TODO("Not yet implemented")
    }
}
