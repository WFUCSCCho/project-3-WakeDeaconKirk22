/***************************************************************************
 @file: Proj3.java
 @description: This program is the main function to run all the sorting algorithms
 and write to snalysis.txt and sorted.txt with the dataset NBAPlayer.txt
 @author:  Kennedy Kirk
 @date  Nov 14,2024

 *******************************************************************************/
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Proj3 {
    // Sorting Method declarations
    // Merge Sort
    public static <T extends Comparable> void mergeSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        //base case
        if (left < right) {
            //divide and conquer and recurisevly call
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            //merge sorted halves
            merge(a, left, mid, right);
        }


    }

    public static <T extends Comparable> void merge(ArrayList<T> a, int left, int mid, int right) {
        // Finish Me
        //calc the size of subarrays
        int a1 = mid - left + 1;
        int a2 = right - mid;
        //Copy Temp array
        ArrayList<T>leftArray = new ArrayList<>();
        ArrayList<T>rightArray = new ArrayList<>();
      //Copy data into temp array
        for (int i = 0; i < a1; i++) {
            leftArray.add(a.get(left+i));
        }
        for(int i = 0; i < a2; i++) {
            rightArray.add(a.get(mid+i+1));
        }
        // merge temp array back into original
        int i = 0, j = 0;
        int k = left;
        while (i < a1 && j < a2) {
            if (leftArray.get(i).compareTo(rightArray.get(j)) <= 0) {
                a.set(k, leftArray.get(i));
                i++;

            }else{
                a.set(k, rightArray.get(j));
                j++;
            }
            k++;

        }
        // Copy into left array
        while (i < a1) {
            a.set(k, leftArray.get(i));
            i++;
            k++;
        }
        //Copy into right array
        while (j < a2) {
            a.set(k, rightArray.get(j));
            j++;
            k++;
        }

    }

    // Quick Sort
    public static <T extends Comparable> void quickSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        if (left < right) {
            //base case
            int pivot = partition(a, left, right);
            //recurive sort the left and right
            quickSort(a, left, pivot - 1);
            quickSort(a, pivot + 1, right);
        }
    }

    public static <T extends Comparable> int partition (ArrayList<T> a, int left, int right) {
        // Finish Me
        //seet pivot as the first element
        T pivot = a.get(left);
        int i = left ;
        for (int j = left + 1; j <= right; j++) {
            //if curr element is less than or equal to the pivot swap
            if (a.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(a, i, j);

            }
        }
        //Swap the pivot
        swap(a,left,i);
        // return pivot indec
        return i;
    }

    static <T> void swap(ArrayList<T> a, int i, int j) {
        T temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    // Heap Sort
    public static <T extends Comparable> void heapSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        //build heap
         for(int i = (right -1 )/2 ; i>=left ; i--){
         heapify(a, i, right);

        }
         //extract elements from heap one by omne
         for(int i= right;i > left ; i--){
             swap(a,left,i);
             heapify(a,left,i-1);
         }

    }

    public static <T extends Comparable> void heapify (ArrayList<T> a, int left, int right) {
        // Finish Me
        int largest = left;
        int leftChild = 2 * left + 1;
        int rightChild = 2 * left + 2;
        // if left is larger than current node
        if (leftChild <= right &&a.get(leftChild).compareTo(a.get(largest)) > 0) {
            largest = leftChild;


        }
        // if the right chid is larger than the current node
        if (rightChild <= right &&a.get(rightChild).compareTo(a.get(largest)) > 0) {
            largest = rightChild;
        }
        if(largest != left){
            swap(a, left, largest);
            heapify(a, largest, right);
        }

    }

    // Bubble Sort
    public static <T extends Comparable> int bubbleSort(ArrayList<T> a, int size) {
        // Finish Me
        int comparisons = 0;
        boolean swapped;
        for(int i = 0; i < size-1; i++) {
            swapped = false;
            for(int j = 0; j < size -i -1; j++) {
                comparisons++;
                if(a.get(j).compareTo(a.get(j+1)) > 0) {
                    swap(a, j, j+1);
                    swapped = true;
                }

            }
            // if no elements are swapped the list is sorted
            if(!swapped) {
                break;

            }

        }
        return comparisons;
    }

    // Odd-Even Transposition Sort
    public static <T extends Comparable> int transpositionSort(ArrayList<T> a, int size) {
        // Finish Me
        int comparisons = 0;
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            //odd index passes
                for (int i =1; i < size -1; i+=2) {
                    comparisons++;
                    if(a.get(i).compareTo(a.get(i+1)) > 0) {
                        swap(a, i, i+1);
                        sorted = false;
                    }
                }
                //even index passes
                for(int i =0;i<size-1;i+=2) {
                    comparisons++;
                    if(a.get(i).compareTo(a.get(i+1)) > 0) {
                        swap(a, i, i+1);
                        sorted = false;
                    }
                }
        }
        return comparisons;
    }
    public static void writeToFile(String content, String filePath, boolean sorted) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {
            printWriter.println(content);
        } catch (IOException e) {
            System.out.println("Error found while writing" + e.getMessage());
        }

    }




        public static void main (String[]args)  throws IOException {
    /*test
      ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(9,7,5,11,3));
      System.out.println("Original list:"+testList);
      ArrayList<Integer>mergedList = new ArrayList<>(testList);
      mergeSort(mergedList,0,mergedList.size()-1);
      System.out.println("Merged list:"+mergedList);

      ArrayList<Integer>heapList = new ArrayList<>(testList);
      heapSort(heapList,0,testList.size()-1);
      System.out.println("Heap List:"+heapList);

      ArrayList<Integer>bubbleList = new ArrayList<>(testList);
      int bubbleComparisons = bubbleSort(bubbleList,bubbleList.size());
      System.out.println("Bubble List:"+bubbleList);
      System.out.println("Bubble Comparisons: "+bubbleComparisons);

      ArrayList<Integer>quickSortList = new ArrayList<>(testList);
      quickSort(quickSortList,0,testList.size()-1);
      System.out.println("Quick Sort List:"+quickSortList);

      ArrayList<Integer>transpositionList = new ArrayList<>(testList);
      int transpositionComparisons = transpositionSort(transpositionList,transpositionList.size());
      System.out.println("Transposition List:"+transpositionList);
      System.out.println("Transposition Comparisons: "+transpositionComparisons);

    ArrayList<Integer>mergeList = new ArrayList<>(testList);
    mergeSort(mergeList,0,testList.size()-1);
    System.out.println("Merge List:"+mergeList);

     */
//Storing different arrays for printout
            ArrayList<NBAPlayer> NbaObject = new ArrayList<>();
            ArrayList<NBAPlayer> sortedArray = new ArrayList<>();
            ArrayList<NBAPlayer> shuffleArray = new ArrayList<>();
            ArrayList<NBAPlayer> reversedArray = new ArrayList<>();
            String fileWriter;
            int comparisons;
            long startTime;
            long endTime;


            if (args.length != 3) {
                System.err.println("Usage: java TestSort  <input file> <Sort type> <number of lines>");
                System.exit(1);
            }


            String inputFileName = args[0];
            String sortType = args[1];
            int numLines = Integer.parseInt(args[2]);

            // For file input
            FileInputStream inputFileNameStream = null;
            Scanner inputFileNameScanner = null;

            // Open the input file
            inputFileNameStream = new FileInputStream(inputFileName);
            inputFileNameScanner = new Scanner(inputFileNameStream);

            // ignore first line
            inputFileNameScanner.nextLine();
            for (int i = 0; i < numLines; i++) {
                String temp = inputFileNameScanner.nextLine();
                String[] command = temp.split(",");
                NBAPlayer player = new NBAPlayer(Integer.parseInt(command[0]), // id
                        command[1],//name
                        command[2], // team
                        Double.parseDouble(command[3]), // age
                        Double.parseDouble(command[4]), // player height
                        Double.parseDouble(command[5]), // player weight
                        command[6], // college name
                        command[7], // country name
                        command[8], // draft year
                        command[9], // draft round
                        command[10], // draft number
                        command[11], // games played (gp)
                        Double.parseDouble(command[12]), // points
                        Double.parseDouble(command[13]), // rebounds
                        Double.parseDouble(command[14]), // assists
                        Double.parseDouble(command[15]), // net rating
                        Double.parseDouble(command[16]), // offensive rebound percentage
                        Double.parseDouble(command[17]), // defensive rebound percentage
                        Double.parseDouble(command[18]), // usage percentage
                        Double.parseDouble(command[19]), // assist percentage
                        Double.parseDouble(command[20]),
                        command[21]);
                NbaObject.add(player);
            }


            switch(sortType){ // writes the different cases for the command line arguements

                case "MergeSort":
                    sortedArray = NbaObject; //write to file the sorted array
                    Collections.sort(sortedArray);
                startTime = System.nanoTime();
                System.out.println(sortedArray.toString());
            mergeSort(sortedArray, 0, sortedArray.size() - 1);
            endTime = System.nanoTime();
            fileWriter = "MergeSort: "+ " Number of lines: "+numLines +" time:"+(endTime - startTime)+"ns";
            System.out.println(fileWriter);
            writeToFile(fileWriter,"analysis.txt",true);



            shuffleArray = NbaObject; ////write to file the shuffle array
            Collections.shuffle(shuffleArray);
            startTime = System.nanoTime();
            System.out.println(shuffleArray.toString());
            mergeSort(shuffleArray, 0, shuffleArray.size() - 1);
            endTime = System.nanoTime();
            fileWriter = "Merge Sort Shuffle:"+" Number of lines: "+numLines +" time:"+(endTime - startTime)+"ns";
            System.out.println(fileWriter);
            writeToFile(fileWriter,"analysis.txt",true);


            reversedArray = NbaObject;  //write to file the reversed array
            Collections.sort(reversedArray, Collections.reverseOrder());
            startTime = System.nanoTime();
            System.out.println(reversedArray.toString());
            mergeSort(reversedArray, 0, reversedArray.size() - 1);
            endTime = System.nanoTime();
            fileWriter = "Merge Sorted reversed:" +" Number of lines: "+numLines +" time:"+(endTime - startTime)+"ns";
            System.out.println(fileWriter);
            writeToFile(fileWriter,"analysis.txt",true);
                    writeToFile("\nSorted Array:" + sortedArray.toString() + "\nShuffle :"+ shuffleArray.toString()+ "\nReverse:"+reversedArray.toString(), "sorted.txt",false);
            break;

//Cases for the command line arguments
                case "QuickSort":

                    sortedArray = NbaObject; //write to file the sorted array as above
                    Collections.sort(sortedArray);
                    startTime = System.nanoTime();
                    System.out.println(sortedArray.toString());
                    quickSort(sortedArray, 0, sortedArray.size() - 1);
                    endTime = System.nanoTime();
                    fileWriter ="Quick Sort: "+" Number of lines: "+ numLines +" time:"+(endTime - startTime)+"ns";
                    System.out.println(fileWriter);
                    writeToFile(fileWriter,"analysis.txt",true);



                    shuffleArray = NbaObject;
                    Collections.shuffle(shuffleArray);
                    startTime = System.nanoTime();
                    System.out.println(shuffleArray.toString());
                    quickSort(shuffleArray, 0, shuffleArray.size() - 1);
                    endTime = System.nanoTime();
                    fileWriter = "Quick Sort shuffle: "+" Number of lines: "+numLines +" time:"+(endTime - startTime)+"ns";
                    System.out.println(fileWriter);
                    writeToFile(fileWriter,"analysis.txt",true);

                    reversedArray = NbaObject;
                    Collections.sort(reversedArray, Collections.reverseOrder());
                    startTime = System.nanoTime();
                    System.out.println(reversedArray.toString());
                    quickSort(reversedArray, 0, reversedArray.size() - 1);
                    endTime = System.nanoTime();
                    fileWriter= "Quick Sort Reversed: "+" Number of lines: "+numLines +" time:"+(endTime - startTime)+"ns";
                    System.out.println(fileWriter);
                    writeToFile(fileWriter,"analysis.txt",true);
                    writeToFile("\nSorted Array:" + sortedArray.toString() + "\nShuffle :"+ shuffleArray.toString()+ "\nReverse:"+reversedArray.toString(), "sorted.txt",false);
            break;

            case "HeapSort":
                sortedArray = NbaObject;
                Collections.sort(sortedArray);
                startTime = System.nanoTime();
                System.out.println(sortedArray.toString());
                heapSort(sortedArray, 0,sortedArray.size() - 1);
                endTime = System.nanoTime();
                fileWriter = "HeapSort:"+" Number of lines: "+ numLines +" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);


                shuffleArray = NbaObject;
                Collections.shuffle(shuffleArray);
                startTime = System.nanoTime();
                System.out.println(shuffleArray.toString());
                heapSort(shuffleArray, 0, shuffleArray.size() - 1);
                endTime = System.nanoTime();
                fileWriter ="HeapSort shuffle: "+ " Number of lines: "+numLines +" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);

                reversedArray = NbaObject;
                Collections.sort(reversedArray, Collections.reverseOrder());
                startTime = System.nanoTime();
                System.out.println(reversedArray.toString());
                heapSort(reversedArray, 0, reversedArray.size() - 1);
                endTime = System.nanoTime();
                fileWriter ="HeapSort Reversed:"+ " Number of lines: "+numLines +" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);
                writeToFile("\nSorted Array:" + sortedArray.toString() + "\nShuffle :"+ shuffleArray.toString()+ "\nReverse:"+reversedArray.toString(), "sorted.txt",false);
                break;



            case "BubbleSort":
                sortedArray = NbaObject;
                Collections.sort(sortedArray);
                startTime = System.nanoTime();
                System.out.println(sortedArray.toString());
                comparisons= bubbleSort(sortedArray,sortedArray.size() - 1);
                endTime = System.nanoTime();
                fileWriter = "Bubble Sort: "+" Number of lines:"+numLines+" Number of Comparisons: "+comparisons+" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);

                shuffleArray= NbaObject;
                Collections.shuffle(shuffleArray);
                startTime = System.nanoTime();
                System.out.println(shuffleArray.toString());
                comparisons= bubbleSort(shuffleArray,shuffleArray.size() - 1);
                endTime = System.nanoTime();
                fileWriter ="Bubble Sort:"+ " Number of lines: "+numLines+" Number of Comparisons: "+comparisons+" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);

                reversedArray= NbaObject;
                Collections.sort(reversedArray, Collections.reverseOrder());
                startTime = System.nanoTime();
                System.out.println(reversedArray.toString());
                comparisons= bubbleSort(reversedArray,reversedArray.size() - 1);
                endTime = System.nanoTime();
                fileWriter = "Bubble Sort reversed:"+ " Number of lines: "+ numLines +" Number of Comparisons: "+comparisons+" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);

                writeToFile("\nSorted Array:" + sortedArray.toString() + "\nShuffle :"+ shuffleArray.toString()+ "\nReverse:"+reversedArray.toString(), "sorted.txt",false);
                break;






            case "OddEvenSort":
                sortedArray = NbaObject;
                Collections.sort(sortedArray);
                startTime = System.nanoTime();
                System.out.println(sortedArray.toString());
                comparisons =transpositionSort(sortedArray,sortedArray.size() );
                endTime = System.nanoTime();
                fileWriter ="Odd Even Sort"+" Number of lines: "+ numLines+" Number of comparisons: "+ comparisons+" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);

                shuffleArray= NbaObject;
                Collections.shuffle(shuffleArray);
                startTime = System.nanoTime();
                System.out.println(shuffleArray.toString());
                comparisons= transpositionSort(shuffleArray,shuffleArray.size() );
                endTime = System.nanoTime();
                fileWriter ="Odd even Sort Shuffle:"+" Number of lines: "+numLines+" Number of comparisons: "+ comparisons+" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);


                reversedArray = NbaObject;
                Collections.sort(reversedArray, Collections.reverseOrder());
                startTime = System.nanoTime();
                System.out.println(reversedArray.toString());
                comparisons= transpositionSort(reversedArray,reversedArray.size() );
                endTime = System.nanoTime();
                fileWriter = "Odd even Sort Reversed: " + " Number of lines: "+numLines+ " Number of comparisons: "+ comparisons+" time:"+(endTime - startTime)+"ns";
                System.out.println(fileWriter);
                writeToFile(fileWriter,"analysis.txt",true);
                writeToFile("\nSorted Array:" + sortedArray.toString() + "\nShuffle :"+ shuffleArray.toString()+ "\nReverse:"+reversedArray.toString(), "sorted.txt",false);
                break;

              

            }


        }
    }

