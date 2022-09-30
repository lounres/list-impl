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

    /**
     * Helps GC to dispose of the node.
     */
    private fun <V> Node<V>.dispose() {
        nextNode = null
        @Suppress("UNCHECKED_CAST")
        value = null as V
    }
    
    operator fun get(index: Int): T {
        require(index in 0 until size-1)
        return getNode(index).value
    }
    
    operator fun set(index: Int, obj: T) {
        require(index in 0 until size)
        getNode(index).value = obj
    }
    
    fun insertFirst(value: T) {
        head = Node(value = value, nextNode = head)
        if (last == null) last = head
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
        when (index) {
            0 -> insertFirst(value)
            size -> insertLast(value)
            else -> {
                val prevNode = getNode(index-1)
                val newNode = Node(value, prevNode.nextNode)
                prevNode.nextNode = newNode
                size++
            }
        }
    }

    fun removeAt(index: Int) {
        require(index in 0 until size)
        if (index == 0) {
            val formerHeadNode = head!!
            head = formerHeadNode.nextNode
            if (size == 1) last = null
            formerHeadNode.dispose()
        }
        else {
            val previousNode = getNode(index - 1)
            val currentNode = previousNode.nextNode!!
            previousNode.nextNode = currentNode.nextNode
            if (index == size - 1) last = previousNode
            currentNode.dispose()
        }
        size--
    }
    
    fun find(obj: T): Int {
        var currentIndex = 0
        var currentNode = head
        while (currentNode != null) {
            if (currentNode.value == obj) return currentIndex
            currentNode = currentNode.nextNode
            currentIndex++
        }
        return -1
    }
    
    fun clear() {
        var currentNode = head
        head = null
        last = null
        size = 0
        while (currentNode != null) {
            val oldNode = currentNode
            currentNode = currentNode.nextNode
            oldNode.dispose()
        }
    }
}
