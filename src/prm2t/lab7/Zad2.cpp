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



struct record* compute_three_best(struct record results[], int number_of_results){ // results - struktura z imionami i czasami
    record* best_times[number_of_results];
    int temp;
    record temp2{};

    for (int i = 0; i < number_of_results; ++i) {
        temp = results[0].time;
        temp2 = results[0];
        for (int j = 0; j < TABLE_SIZE; ++j) {
            if(results[j].time < temp){
                temp = results[j].time;
                temp2 = results[j];
            }
        }
        best_times[i] = &temp2;
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
                break;
            case 2:
                std::cout << "Exiting program" << std::endl;
                return 0;
            default:
                std::cout << "Wrong option, choose once again" << std::endl;
        }
    }
    return 0;
}

