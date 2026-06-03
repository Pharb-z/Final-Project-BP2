package queue;

import node.*;

public class OrderQueue {

    QueueNode front, rear;
    int count;
    double total;

    OrderQueue() {

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
}
