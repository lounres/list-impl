class LinkedList<T> {
    
    class Node<T>(var value: T, var nextNode: Node<T>? = null)
    
    private var head: Node<T>? = null
    
    private var last: Node<T>? = null
    
    private var size: Int = 0
    
    fun count(): Int = size
       
    operator fun get(index: Int): T {
        var current = head
        var currentIndex = 0
        while (current != null && currentIndex < index) {
            current = current.nextNode
            currentIndex++
        }
        return current
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
        if (size==0) {
            insertFirst(value)
        }
        else {
            last?.nextNode = Node(value = value)
            last= last?.nextNode
            size++
        }
    }
    
    fun insert(index: Int, value: T) {
        if (size==0 || index == size) {
            insertFirst(value)
        }
        else {
            var prev = get(index-1)
            var newNode = Node(value, prev.nextNode)
            prev.nextNode = newNode
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
