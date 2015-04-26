package AudioLogic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.emory.mathcs.jtransforms.fft.DoubleFFT_1D;

/**
 *
 * @author Kata
 */
public class LoadFile {

    DoubleFFT_1D fft = new DoubleFFT_1D(4096);
    double[] as = new double[2 * 4096];
    double[] poz = new double[500];
    long pt[] = new long[5];

    public void loadMic(byte data[], Matcher match, int pz, boolean mic, String nume) {

        for (int o = 0; o < 4096; o++) {
            as[o] = data[o];
        }
        fft.realForwardFull(as);
        pt = new long[5];
        for (int i = 40; i < 300; i++) {
            double mag = Math.log(Math.sqrt(as[2 * i] * as[2 * i] + as[2 * i + 1] * as[2 * i + 1]) + 1);

            int index = getIndex(i);

            if (mag > poz[index]) {
                poz[index] = mag;
                pt[index] = i;
            }
        }
        if (mic) {
            match.get(pt, pz);
        } else {
            match.insert(pt, new PointPOJO(pz, nume));
        }
    }

    public final int UPPER_LIMIT = 300;
    public final int LOWER_LIMIT = 40;

    public final int[] RANGE = new int[]{40, 80, 120, 180, UPPER_LIMIT + 1};

    public int getIndex(int freq) {
        int i = 0;
        while (RANGE[i] < freq) {
            i++;
        }
        return i;
    }

}
