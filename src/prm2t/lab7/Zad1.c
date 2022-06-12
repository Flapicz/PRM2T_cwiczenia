#include <stdio.h>

#define TABLE_SIZE 10
#define PODIUM 3
char *names[TABLE_SIZE] = {
 "Jan", "Krystyna", "Barbara", "Pawel", "Luiza", "Stefan", "Monika",
 "Maria", "Tadeusz", "Konrad"
};

int times[TABLE_SIZE] = {
 56, 60, 51, 44, 66, 50, 49, 62, 43, 70
};

int best_times[PODIUM] = { //lista indeksów najszybszych czasów
    0,1,2
};

void sort() {
    int n = PODIUM;
    int t = 0;
    do {
        for (int i = 0; i < n - 1; i++)
            if (times[best_times[i]] < times[best_times[i + 1]]) {
                t = best_times[i];
                best_times[i] = best_times[i+1];
                best_times[i+1] = t;
            }
        n = n - 1;
    } while (n > 1);
}

void reset(){
    for (int i = 0; i < PODIUM; ++i) {
        best_times[i] = i;
    }
}

int main(int argc, char** argv) {
 while (1) {
    printf("Select an option:\n 1 - calculate\n 2 - exit program\n");
    int option;
    scanf("%d", &option);
    switch (option) {
        case 1:
            reset();
            sort();
            for (int i = 3; i < TABLE_SIZE; i++) {
                if(times[i]< times[best_times[0]]){
                    best_times[0] = i;
                    sort();
                }
            }
            printf("Best times:\n");
            int n = 1;
            for(int i=PODIUM-1;i>=0;--i) {
                printf("%d) %s - %d\n", n++, names[best_times[i]], times[best_times[i]]);
            }
            printf("\n");
            break;

        case 2:
            printf("Exiting program\n");
            return 0;
        default:
            printf("Wrong option, choose once again\n");
    }
 }
 return 0;
}

