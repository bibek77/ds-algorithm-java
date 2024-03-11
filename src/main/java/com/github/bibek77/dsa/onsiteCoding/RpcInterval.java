package com.github.bibek77.dsa.onsiteCoding;

import java.util.*;

/**
 * @author bibek
 * You have a stream of rpc requests coming in. Each log is of the
 * form {id, timestamp, type(start/end)}. Given a timeout T, you need to figure out at the earliest possible time if a request
 * has timed out.
 * Eg :
 * id - time - type
 * 0 - 0 - Start
 * 1 - 1 - Start
 * 0 - 2 - End
 * 2 - 6 - Start
 * 1 - 7 - End
 * Timeout = 3
 * Answer : {1, 6} ( figured out id 1 had timed out at time 6 )
 */
public class RpcInterval {
    public static void main(String[] args) {

        Log log1 = new Log(0, 0, "start");
        Log log2 = new Log(1, 1, "start");
        Log log3 = new Log(0, 2, "end");
        Log log4 = new Log(2, 6, "start");
        Log log5 = new Log(1, 7, "end");
        Log log6 = new Log(3, 8, "start");
        Log log7 = new Log(4, 9, "start");
        Log log8 = new Log(5, 11, "start");
        Log log9 = new Log(4, 11, "end");
        Log log10 = new Log(2, 13, "end");

        List<Log> rpcLogs = Arrays.asList(log1, log2, log3, log4, log5, log6, log7, log8, log9, log10);
        int timeout = 3;
        RpcInterval rpcInterval = new RpcInterval();
        List<int[]> result = rpcInterval.rpcTimeout(rpcLogs, timeout);
        for (int[] data : result) {
            System.out.println("id : " + data[0] + ", timed Out at : " + data[1]);
        }


    }

    public List<int[]> rpcTimeout(List<Log> rpcLogs, int timeout) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, String> event = new HashMap<>();
        for (Log rpcLog : rpcLogs) {
            int id = rpcLog.id;
            int time = rpcLog.time;
            String type = rpcLog.type;

            event.put(id, type);

            if (!priorityQueue.isEmpty()) {
                int[] firstLog = priorityQueue.peek();
                if (firstLog[1] + timeout < time && !event.get(firstLog[0]).equalsIgnoreCase("end")) {
                    result.add(new int[]{firstLog[0], time});
                    priorityQueue.poll();
                } else if (event.get(firstLog[0]).equalsIgnoreCase("end")) {
                    priorityQueue.poll();
                }
            }

            priorityQueue.add(new int[]{id, time});
        }
        return result;
    }

    static class Log {
        int id;
        int time;
        String type;

        Log(int id, int time, String type) {
            this.id = id;
            this.time = time;
            this.type = type;
        }
    }
}
