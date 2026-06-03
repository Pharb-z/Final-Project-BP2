package queue;

import node.*;

public class OrderQueue {

    QueueNode front, rear;
    int count;
    double total;

    public OrderQueue() {

    }

    public void enqueue(QueueNode OrderNode) {
        if (rear == null) {
            front = rear = OrderNode;
        } else {
            rear.next = OrderNode;
            rear = OrderNode;
        }
        total = total + (OrderNode.order.price * OrderNode.order.qty);
        //total = total + (OrderNode.order.price * OrderNode.order.qty);
    }

    public void dequeue() {
        QueueNode t = front;
        if (t == null) {
            System.out.println("Antrian kosong!");
        }else if (t.next == null) {
            front = rear = null;
        }else{
            front = front.next;
            t.next = null;
        }
        System.out.println(t);
        if(t == null){
            System.out.println("Antrian kosong!");
        }else{
            
            System.out.println(t.order.service + " out...");
        }
    }
}
