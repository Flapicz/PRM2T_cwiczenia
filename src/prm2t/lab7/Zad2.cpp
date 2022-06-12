#include <iostream>

#define TABLE_SIZE 10
#define PODIUM 3
char const *names[TABLE_SIZE] = {
        "Jan", "Krystyna", "Barbara", "Pawel", "Luiza", "Stefan", "Monika",
        "Maria", "Tadeusz", "Konrad"
};

int times[TABLE_SIZE] = {
        56, 60, 51, 44, 66, 50, 49, 62, 43, 70
};

//int best_times[PODIUM] = { //lista indeksów najszybszych czasów
//        0,1,2
//};

struct record{
    char const *name;
    int time;
} runner1, runner2, runner3, runner4, runner5, runner6, runner7, runner8, runner9, runner10;

record runners[TABLE_SIZE] = { //lista ulatwiajaca wpisanie danych
    runner1, runner2, runner3, runner4, runner5, runner6, runner7, runner8, runner9, runner10
};




void sort(record* best_times[]) {
    int n = PODIUM;
    record t;
    do {
        for (int i = 0; i < n - 1; i++)
            if (best_times[i]->time < best_times[i + 1]->time) {
                t = *best_times[i];
                best_times[i] = best_times[i+1];
                best_times[i+1] = t;
            }
        n = n - 1;
    } while (n > 1);
}

//void reset(record best_times[]){
//    for (int i = 0; i < PODIUM; ++i) {
//        best_times[i] = i;
//    }
//}

struct record* compute_three_best(struct record data[], int number_of_results){
    record* best_times[number_of_results];
    sort(best_times);
    for (int i = 3; i < TABLE_SIZE; i++) {
        if(data[i].time < best_times[0].time){
            best_times[0] = data[i];
            sort(best_times);
        }
    }
    return *best_times;
};


int main(int argc, char **argv) {
    for (int i = 0; i < TABLE_SIZE; ++i) {
        runners[i].name = names[i];
        runners[i].time = times[i];
    }

    while (1) {
        std::cout << "Select an option:\n1 - calculate\n2 - exit program" << std::endl;
        int option;
        std::cin >> option;
        int n;
        record* results;
        switch (option) {
            case 1:
                results = compute_three_best(runners, PODIUM);
                std::cout << "Best times:" << std::endl;
                n = 1;
                for(int i=PODIUM-1;i>=0;--i) {
                    std::cout << n++ << ") " << results[i].name << " - " << results[i].time << std::endl;
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

