import java.util.*;

public class EightPuzzleSolver {

    // Create 3*3 matrix
    static void show(String s){
        for(int i=0; i<9; i++){
            System.out.print((s.charAt(i)=='0' ? "_" : s.charAt(i)) + " ");
            if(i % 3 == 2) System.out.println();
        }
        System.out.println("----------");
    }

    // neighbors + move directions
    static List<String[]> neighbors(String s){
        List<String[]> list = new ArrayList<>();

        int z = s.indexOf('0');   // Zero place
        int r = z / 3, c = z % 3;

        // movement and directions (Up, Down, Left, Right)
        int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}};
        char[] dirs = {'U','D','L','R'};

        for(int i=0; i<4; i++){
            int nr = r + moves[i][0];
            int nc = c + moves[i][1];

            if(nr>=0 && nr<3 && nc>=0 && nc<3){
                int nz = nr*3 + nc;

                char[] arr = s.toCharArray();
                char tmp = arr[z];
                arr[z] = arr[nz];
                arr[nz] = tmp;

                list.add(new String[]{ new String(arr), String.valueOf(dirs[i]) });
            }
        }
        // return null;
        return list;
    }

    // BFS + saving move directions in separate Maps.
    static Map<String,String> parent = new HashMap<>();
    static Map<String,String> direction = new HashMap<>();

    static void bfs(String start, String goal){

        // a new LinkedList
        Queue<String> q = new LinkedList<>();
        q.add(start);
        parent.put(start, null);
        direction.put(start, "");

        System.out.println("\n=== BFS Started ===\n");

        // continue until q is not empty.
        while(!q.isEmpty()){
            String cur = q.poll();

            System.out.println("Checking state (last move = " + direction.get(cur) + "):");
            show(cur);

            if(cur.equals(goal)){
                System.out.println("Goal reached!\n");
                return;
            }

            for(String[] nxt : neighbors(cur)){
                String nextState = nxt[0];
                String moveDir   = nxt[1];

                if(!parent.containsKey(nextState)){
                    parent.put(nextState, cur);
                    direction.put(nextState, moveDir);
                    q.add(nextState);

                    System.out.println("Generated new state (move " + moveDir + "):");
                    show(nextState);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Initial (9 digits 0-8): ");
        String start = sc.nextLine().replace(" ", "");

        System.out.print("Goal (9 digits 0-8): ");
        String goal = sc.nextLine().replace(" ", "");

        bfs(start, goal);

        // final path (route print)
        System.out.println("\n=== Solution Path ===");

        List<String> path = new ArrayList<>();
        List<String> moves = new ArrayList<>();

        String cur = goal;
        while(cur != null){
            path.add(cur);
            moves.add(direction.get(cur));
            cur = parent.get(cur);
        }

        // Let's reverse the path and moves.
        Collections.reverse(path);
        Collections.reverse(moves);

        StringBuilder finalMoves = new StringBuilder();

        for(int i=0;i<path.size();i++){
            System.out.println("Move: " + moves.get(i));
            finalMoves.append(moves.get(i));
            show(path.get(i));
        }

        System.out.println("\nFinal move sequence (apply to 0): " + finalMoves.toString());
    }
}