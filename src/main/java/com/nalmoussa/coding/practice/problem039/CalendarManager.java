package com.nalmoussa.coding.practice.problem039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
We are writing a tool to help users manage their calendars. Given an unordered list of times of day when people are busy, write a function that tells us the intervals during the day when ALL of them are available.

Each time is expressed as an integer using 24-hour notation, such as 1200 (12:00), 1530 (15:30), or 800 (8:00).

Sample input:

p1_meetings = [
  (1230, 1300),
  ( 845, 900),
  (1300, 1500),
]

p2_meetings = [
  ( 0, 844),
  ( 930, 1200),
  (1515, 1546),
  (1600, 2400),
]

p3_meetings = [
  ( 845, 915),
  (1515, 1545),
  (1235, 1245),
]

schedules1 = [p1_meetings, p2_meetings, p3_meetings]
schedules2 = [p1_meetings, p3_meetings]

Expected output:

findAvailableTimes(schedules1)
 => [  844,  845 ],
    [  915,  930 ],
    [ 1200, 1230 ],
    [ 1500, 1515 ],
    [ 1546, 1600 ]

findAvailableTimes(schedules2)
 => [    0,  845 ],
    [  915, 1230 ],
    [ 1500, 1515 ],
    [ 1545, 2400 ]

n = number of meetings
m = number of schedules
*/
public class CalendarManager {
  private static final int START = 0;
  private static final int END = 1;

  public static void main(String[] argv) {
    firstQuestion();
    secondQuestion();
  }

  private static void firstQuestion() {
    int[][] meetings = {
        {1230, 1300},
        { 845,  900},
        {1300, 1500}
    };

    int[] newMeeting1 = {900, 1230};
    System.out.println(isAvailable(meetings, newMeeting1));

    int[] newMeeting2 = {1245, 1315};
    System.out.println(isAvailable(meetings, newMeeting2));
  }

  private static void secondQuestion() {
    int[][] p1Meetings = {
        {1230, 1300},
        { 845,  900},
        {1300, 1500}
    };
    int[][] p2Meetings = {
        { 0, 844},
        { 930, 1200},
        {1515, 1546},
        {1600, 2400}
    };
    int[][] p3Meetings = {
        { 845,  915},
        {1515, 1545},
        {1235, 1245}
    };

    List<int[][]> schedules1 = Arrays.asList(p1Meetings, p2Meetings, p3Meetings);
    List<int[][]> schedules2 = Arrays.asList(p1Meetings, p3Meetings);

    int[][] availableTimes1 = findAvailableTimes(schedules1);
    printIntervals(availableTimes1);
    System.out.println("=======");
    int[][] availableTimes2 = findAvailableTimes(schedules2);
    printIntervals(availableTimes2);
  }

  private static int[][] findAvailableTimes(List<int[][]> schedules) {
    // put all meetings in a priority queue
    PriorityQueue<Integer> timeline = new PriorityQueue<>();
    for (int[][] meetings : schedules) {
      for (int[] meeting : meetings) {
        timeline.add(intervalToIntValue(meeting)); // [1030, 1145] => 10301145
      }
    }

    List<int[]> availableTimesAsList = new ArrayList<>();
    int[] currentMeeting = (timeline.isEmpty()) ? (new int[2]) : intValueToInterval(timeline.poll());
    int start = 0;
    while (!timeline.isEmpty()) {
      int[] nextMeeting = intValueToInterval(timeline.poll());
      if (isDisjoint(currentMeeting, nextMeeting)) {
        addAvailableTime(availableTimesAsList, start, currentMeeting[START]);
        start = currentMeeting[END];
        currentMeeting = nextMeeting;
      } else {
        currentMeeting = joinOverlappingIntervals(currentMeeting, nextMeeting);
      }
    }
    addAvailableTime(availableTimesAsList, start, currentMeeting[START]);
    addAvailableTime(availableTimesAsList, currentMeeting[END], 2400);

    return availableTimesAsList.toArray(int[][]::new);
  }

  private static void addAvailableTime(List<int[]> availableTimesAsList, int start, int end) {
    if (start < end) {
      int[] availableTime = new int[2];
      availableTime[START] = start;
      availableTime[END] = end;
      availableTimesAsList.add(availableTime);
    }
  }

  private static int[] joinOverlappingIntervals(int[] leftInterval, int[] rightInterval) {
    int[] interval = new int[2];
    interval[START] = leftInterval[START];

    interval[END] = Math.max(rightInterval[END], leftInterval[END]);
    return interval;
  }

  private static int intervalToIntValue(int[] interval) {
    int offset = 10000;
    return interval[START] * offset + interval[END];
  }

  private static int[] intValueToInterval(int value) {
    int offset = 10000;
    int[] interval = new int[2];
    interval[START] = value / offset;
    interval[END] = value % offset;
    return interval;
  }

  private static void printIntervals(int[][] intervals) {
    for (int[] interval : intervals) {
      printInterval(interval[START], interval[END]);
    }
  }

  private static void printInterval(int start, int end) {
    String startAsString = fixedLengthNumber(start);
    String endAsString = fixedLengthNumber(end);
    System.out.printf("[%s,%s]%n", startAsString, endAsString);
  }

  private static String fixedLengthNumber(int num) {
    String withExtraSpace = "     " + num;
    int length = withExtraSpace.length();
    return withExtraSpace.substring(length - 5);
  }

  private static boolean isAvailable(int[][] meetings, int[] newMeeting) {
    for (int[] existingMeeting : meetings) {
      if (!isDisjoint(existingMeeting, newMeeting)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isDisjoint(int[] interval1, int[] interval2) {
    int leftEnd, rightStart;
    if (interval1[START] < interval2[START]) {
      leftEnd = interval1[END];
      rightStart = interval2[START];
    } else {
      leftEnd = interval2[END];
      rightStart = interval1[START];
    }

    return leftEnd <= rightStart;
  }
}
