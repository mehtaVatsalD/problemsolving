class Solution {

   static class pair  {
      long first, second;
       public pair(long first, long second) {
          this.first = first;
          this.second = second;
       }
    }

    public pair indexes(long v[], long x) {
        int l =findLeft (v, x, 0, v.length-1);
        int r = findRight (v, x, 0, v.length-1);
        // System.out.println("l: " + l + " r: " + r);
        return new pair(l,r);
    }

    int findLeft(long[] v, long x, int start, int end) {

        // if(start == end && v[start] == x && start == 0) {
        //     return 0;
        // }

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (mid+1 <= v.length-1 && (v[mid] != x && v[mid+1] == x)) {
            return mid+1;
        }
        else if ((v[mid] == x && mid-1<0)) {
            return mid;
        }
        else if (v[mid] >= x) {
            return findLeft(v, x, start, mid-1);
        }
        else {
            return findLeft(v, x, mid+1, end);
        }
    }

    int findRight(long[] v, long x, int start, int end) {

        // System.out.println("start: " + start + " end: " + end);

        // if(start == end && v[start] == x && start == v.length-1) {
        //     return v.length-1;
        // }

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        // System.out.println("mid: " + mid);

        if (mid-1 >= 0 && (v[mid] != x && v[mid-1] == x) ) {
            return mid-1;
        }
        else if ((v[mid] == x && mid+1>=v.length)) {
            return mid;
        }
        else if (v[mid] <= x) {
            return findRight(v, x, mid+1, end);
        }
        else {
            return findRight(v, x, start, mid-1);
        }
    }

}
