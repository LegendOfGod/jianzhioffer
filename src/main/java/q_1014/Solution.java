package q_1014;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lqb
 * @date 2022/1/13 14:44
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 示例 2：
 *
 * 输入：values = [1,2]
 * 输出：2
 *
 * 提示：
 *
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 * 可以分为两部分 values[i] + i+ values[j]  - j
 *
 * 从左到右遍历一次的情况下 认为values[j] - j 是固定值
 * 动态规划变更[0,j - 1]这个范围内 values[i] + i 的最大值 用dp[j-1]记录 那么dp[j] = Max(dp[j-1],values[j] + j)
 * j位置的组合最高分等于dp[j-1] + values[j] - j
 * max = Max(max,dp[j-1]+values[j] - j)
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        List<Integer> dp = new ArrayList<>();
        dp.add(values[0]);
        int max = dp.get(0);
        for (int j = 1; j < values.length; ++j) {
            max = Math.max(max,dp.get(j-1) + values[j] - j);
            dp.add(Math.max(dp.get(j-1),values[j] + j));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = {208,857,70,697,668,79,276,607,328,26,779,171,709,168,967,731,548,675,634,455,473,84,16,691,389,516,304,853,20,301,74,278,777,46,794,618,446,953,999,164,715,668,637,200,660,402,671,332,670,346,236,758,13,151,425,865,295,31,974,114,294,463,446,316,33,631,132,239,836,858,510,103,212,33,737,101,219,325,843,585,279,141,120,604,994,377,404,263,928,927,266,793,171,312,422,733,283,639,979,958,184,193,325,187,69,86,974,627,56,650,302,126,962,734,394,562,37,850,392,183,288,416,71,335,962,135,468,113,525,318,447,83,359,355,447,585,543,181,549,625,645,572,624,596,709,854,761,652,125,594,829,698,991,199,28,414,700,532,394,536,641,478,926,856,991,747,993,236,28,459,540,812,108,939,325,750,313,200,348,489,461,460,953,429,751,376,371,506,853,49,185,299,729,652,16,547,225,319,129,853,993,950,239,161,399,138,945,432,871,463,857,907,737,722,512,290,559,884,608,932,781,864,398,890,574,472,125,620,728,447,150,52,116,786,717,172,549,350,268,951,315,482,170,65,596,830,647,927,983,482,833,771,41,232,852,293,414,784,46,454,425,370,778,218,212,143,953,229,673,403,645,756,847,195,940,193,993,760,587,128,339,955,393,768,666,277,209,737,261,762,11,47,912,905,560,333,55,107,91,424,74,379,827,328,677,517,654,931,961,511,408,932,36,618,450,919,235,931,933,60,413,248,942,978,827,115,32,306,493,944,754,385,145,637,621,766,102,760,335,662,518,891,227,374,589,386,733,892,475,384,390,570,378,445,845,812,679,674,6,382,909,356,15,250,152,860,971,899,899,161,301,824,850,42,886,278,188,506,670,905,750,572,953,117,231,565,62,622,686,438,795,261,192,785,389,461,925,740,854,558,504,401,682,341,431,697,731,299,874,567,386,988,549,64,818,747,683,29,344,732,46,551,894,448,714,34,990,892,711,755,851,522,353,509,870,520,549,805,990,783,990,727,716,421,857,766,156,770,22,609,498,467,957,156,897,839,136,382,43,395,910,662,496,472,582,573,355,849,174,77,900,751,487,530,566,350,15,351,793,166,698,583,858,895,907,942,2,512,895,30,270,585,838,271,905,476,217,536,791,293,836,596,25,417,121,902,74,894,891,94,167,530,503,676,423,989,916,96,997,448,728,394,313,351,295,930,591,161,529,899,875,23,281,404,829,604,920,224,184,696,424,502,725,100,232,174,36,482,510,291,168,424,337,507,340,132,382,536,588,193,918,597,806,693,895,801,12,125,723,790,12,665,628,131,26,610,651,161,190,207,522,194,674,114,897,93,770,291,905,778,425,659,407,669,963,785,2,494,68,841,369,591,929,229,405,163,7,457,737,621,966,959,985,526,833,981,147,816,218,240,429,74,111,416,960,195,86,81,449,602,567,163,266,535,641,829,944,296,417,432,270,142,48,519,757,414,206,79,274,35,387,260,487,180,314,508,629,880,938,463,272,406,163,457,292,926,187,390,349,1000,45,290,810,90,374,214,97,534,302,581,779,412,768,306,498,168,840,594,528,405,893,48,845,526,882,620,275,16,27,310,788,473,756,92,813,854,760,55,550,996,770,644,354,702,998,587,475,354,694,587,925,591,973,146,313,305,121,263,132,75,168,32,759,232,465,390,803,258,55,700,728,74,353,704,184,658,604,854,627,964,319,141,355,676,685,312,521,828,344,996,404,439,73,278,759,384,899,365,342,109,981,473,490,632,738,55,531,116,988,335,461,774,359,509,258,427,824,95,677,313,477,712,533,636,636,433,617,766,592,993,838,150,232,946,60,60,72,238,207,839,603,747,255,630,538,936,825,521,169,263,483,401,745,4,922,604,877,285,985,246,897,999,130,494,379,19,295,294,304,106,600,902,284,631,419,16,881,884,62,803,956,279,169,79,731,903,434,349,756,672,462,537,959,695,914,506,652,190,63,92,179,905,65,5,133,338,819,980,424,954,148,637,664,173,639,994,913,896,518,178,237,960,265,570,149,152,470,292,346,960,862,268,208,117,459,60,542,488,390,30,804,124,129,526,243,906,658,560,426,158,401,902,117,109,290,565,340,469,562,468,971,769,416,227,123,547,40,754,366,863,154,563,486,143,688,540,779,940,780,808,582,475,35,227,653,394,846,341,911,105,801,495,771,240,609,651,758,326,225,2,872,988,548,165,702,720,689,591,357,862,503,356,194,366,167,294,182,200,599,341,591,798,59,344,990,364,923,764,311,214};
        System.out.println(ints.length);
        Solution solution = new Solution();
        System.out.println(solution.maxScoreSightseeingPair(ints));
    }
}