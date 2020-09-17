package dsalgo.graph.common;

public class TaskNode {
    public int task;
    public int dependsOn;

    public TaskNode(int dependsOn, int task) {
        this.task = task;
        this.dependsOn = dependsOn;
    }
}

