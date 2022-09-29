class LinkedList<T> {
    
    class Node<T>(var value: T, var nextNode: Node<T>? = null)
    
    private var head: Node<T>? = null
    
    private var last: Node<T>? = null
    
    private var size: Int = 0
    
    fun count(): Int = size
       
    private fun getNode(index: Int): Node<T> {
        var current = head
        var currentIndex = 0
        while (current != null && currentIndex < index) {
            current = current.nextNode
            currentIndex++
        }
        return current!!
    }
    
    operator fun get(index: Int): T {
        require(index in 0 until size-1)
        return getNode(index).value
    }
    
    operator fun set(index: Int, obj: T) {
        TODO("Not yet implemented")
    }
    
    fun insertFirst(value: T) {
        head = Node(value = value, nextNode = head)
        if (last == null) {
            last = head
        }
        size++
    }

    fun insertLast(value: T) {
        val newLast = Node(value = value)
        last?.nextNode = newLast
        last = newLast
        if (size == 0) head = newLast
        size++
    }
    
    fun insert(index: Int, value: T) {
        require(index in 0 until size)
        if (size==0 || index == size) {
            insertLast(value)
        }
        else {
            var prevNode = getNode(index-1)
            var newNode = Node(value, prevNode.nextNode)
            prevNode.nextNode = newNode
            size++
        }
    }
    
    fun removeAt(index: Int) {
        TODO("Not yet implemented")
    }
    
    fun find(obj: T): Int {
        TODO("Not yet implemented")
    }
    
    fun clear() {
        TODO("Not yet implemented")
    }
}
