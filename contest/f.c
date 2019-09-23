#include <stdio.h>

int main() {
    // your code here
    int n = 0;
    int x1, x2, x3, x4, sum1=0, sum2=0;
    int y1, y2, y3, y4, sum3=0, sum4=0;
    double avg1, avg2;

    scanf("%d %d %d %d", &x1, &x2, &x3, &x4);
    scanf("%d %d %d %d", &y1, &y2, &y3, &y4);

    for (int i=x1+1; i<x2; i++)
         sum1 = sum1 + i;
    for (int i=x3+1; i<x4; i++)
         sum2 = sum2 + i;

    avg1 = (double)sum1/(x2-x1-1) + (double)sum2/(x4-x3-1);
    for (int i=y1+1; i<y2; i++)
         sum3 = sum3 + i;
    for (int i=y3+1; i<y4; i++)
         sum4 = sum4 + i;
    avg2 = (double)sum3/(y2-y1-1) + (double)sum4/(y4-y3-1);


    if (avg1 > avg2)
        printf("Mickie\n");
    else if (avg1 == avg2)
        printf("Tie\n");
    else
        printf("Nickie\n");

    return 0;

}