/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AudioLogic;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

/**
 *
 * @author Kata
 */
public class Matcher {

    public NavigableMap<Long, List<PointPOJO>> hm = null;
    PrintWriter a;
    int c = 0;
    public HashMap matching = new HashMap();
    public HashMap dist = new HashMap();
    public NavigableMap<String, Integer> Names = null;
    DB db = null;

    Matcher() {

        db = DBMaker.newFileDB(new File("HashMaxHeights8"))
                .closeOnJvmShutdown()
                .make();
        hm = db.getTreeMap("maxHeights");
        Names = db.getTreeMap("names");
    }

    public void insert(long points[], PointPOJO pj) {
points[4]=0;

        long hash =
Arrays.hashCode(points);              //hash2(points[0], points[1], points[2], points[3]);

        if (Names.get(pj.name) == null) {
            Names.put(pj.name, 1);
        }
        if (hm.containsKey(hash)) {
            List<PointPOJO> ls = (List<PointPOJO>) hm.get(hash);
            ls.add(pj);
            hm.put(hash, ls);
        } else {

            List<PointPOJO> ls = new ArrayList<>();
            ls.add(pj);
            hm.put(hash, ls);
        }
    }
    String name;

    public void get(long points[], int l) {
points[4]=0;
        long key =Arrays.hashCode(points);
//hash2(points[0], points[1], points[2], points[3]);

        List<PointPOJO> ls = (List<PointPOJO>) hm.get(key);
        if (ls != null) {
            for (PointPOJO pj : ls) {
                HashMap hmo = (HashMap) matching.get(pj.name);
                name = pj.name;
                if (hmo != null) {
                    Integer d = (Integer) hmo.get(Math.abs(pj.location - l));
                    if (d == null) {
                        hmo.put(Math.abs(pj.location - l), 1);
                    } else {
                        hmo.put(Math.abs(pj.location - l), ++d);
                    }

                } else {
                    HashMap a2 = new HashMap();
                    a2.put(Math.abs(pj.location - l), 1);
                    matching.put(pj.name, a2);
                }
            }
        }

    }

    public String analyze() {
        Iterator it2 = Names.entrySet().iterator();
        int mx = -1;
        String nume = null;

        while (it2.hasNext()) {
            Map.Entry pair2 = (Map.Entry) it2.next();

            System.out.println("  " + pair2.getKey());
            HashMap mp = (HashMap) matching.get(pair2.getKey());
            if(mp!=null){
            Iterator it = mp.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if ((int) pair.getValue() > mx) {
                    mx = (int) pair.getValue();
                    nume = (String) pair2.getKey();
                }
                it.remove();
            }
            }

        }
        System.out.println("\n" + mx + " " + nume + "\n");
        return nume;
    }

    
    private long hash2(long points[]) {
        long hs=0;
        for(int i=0;i<points.length-1;i++)
        {
            hs=33*hs+(points[i]);
        }
        return hs;
        
    }

}
