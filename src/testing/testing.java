package testing;

import java.util.Scanner;
import linkedlist.*;
import model.*;
import node.*;
import queue.*;

public class testing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceLL service = new ServiceLL();
        service.addService("SRV1", "Cuci Basah", 4000, "Kiloan");
        Order order = new Order("ORD1", "Wahyu", "Cuci Basah", 6000, "Kiloan", 5);
        QueueNode node = new QueueNode();
        node.order = order;
        OrderQueue queue = new OrderQueue();
        queue.enqueue(node);
        System.out.println("Next?");
        int ch = sc.nextInt();
        sc.nextLine();
        queue.dequeue();
        sc.close();
    }
}
