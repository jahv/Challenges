package hackerrank.ns.contest.w6;


import org.junit.Assert;
import org.junit.Test;

import hackerranck.ns.contest.w6.BoomerangConstellations;

/**
 * Created by ahernandez on 3/22/17.
 */
public class BoomerangConstellationsTest {

    @Test
    public void getDistanceTest() {
        Assert.assertEquals(1, BoomerangConstellations.getDistance(0,1,0,2), 0);
        Assert.assertEquals(1, BoomerangConstellations.getDistance(0,-1,0,0), 0);
        Assert.assertEquals(1, BoomerangConstellations.getDistance(0,2,0,1), 0);
    }
}
