#include <stdio.h>
#include <string.h>

#define MAX 5

typedef struct {
    char courseCode[20];
    char courseName[100];
    char action[20];
} Registration;

Registration stack[MAX];
int top = -1;

/* Check if the stack is empty */
int isEmpty() {
    return top == -1;
}

/* Check if the stack is full */
int isFull() {
    return top == MAX - 1;
}

/* Push a registration onto the stack */
void push() {
    if (isFull()) {
        printf("\nStack is full. Cannot add another registration.\n");
        return;
    }

    top++;

    printf("\nEnter course code: ");
    scanf("%19s", stack[top].courseCode);

    printf("Enter course name: ");
    scanf(" %[^\n]", stack[top].courseName);

    printf("Enter action (ADD/DROP): ");
    scanf("%19s", stack[top].action);

    printf("\nRegistration action added successfully.\n");
}

/* Pop the most recent registration */
void pop() {
    if (isEmpty()) {
        printf("\nNo registration actions available to remove.\n");
        return;
    }

    printf("\n========== REMOVED ACTION ==========\n");
    printf("Course Code: %s\n", stack[top].courseCode);
    printf("Course Name: %s\n", stack[top].courseName);
    printf("Action: %s\n", stack[top].action);
    printf("====================================\n");

    top--;
}

/* View the most recent registration */
void peek() {
    if (isEmpty()) {
        printf("\nNo registration actions available.\n");
        return;
    }

    printf("\n========== MOST RECENT ACTION ==========\n");
    printf("Course Code: %s\n", stack[top].courseCode);
    printf("Course Name: %s\n", stack[top].courseName);
    printf("Action: %s\n", stack[top].action);
    printf("========================================\n");
}

/* Display all registration actions */
void display() {
    int i;

    if (isEmpty()) {
        printf("\nNo registration actions available.\n");
        return;
    }

    printf("\n====== REGISTRATION ACTIONS ======\n");

    for (i = top; i >= 0; i--) {
        printf("Course Code: %s\n", stack[i].courseCode);
        printf("Course Name: %s\n", stack[i].courseName);
        printf("Action: %s\n", stack[i].action);
        printf("---------------------------------\n");
    }
}

int main() {
    int choice;

    do {
        printf("\n==============================================\n");
        printf(" UNIVERSITY COURSE REGISTRATION CONFLICT RESOLVER\n");
        printf("==============================================\n");
        printf("1. Add Registration Action (Push)\n");
        printf("2. Undo Latest Registration (Pop)\n");
        printf("3. View Latest Registration (Peek)\n");
        printf("4. View All Registration Actions\n");
        printf("5. Exit\n");
        printf("==============================================\n");
        printf("Enter your choice: ");

        scanf("%d", &choice);

        switch (choice) {
            case 1:
                push();
                break;

            case 2:
                pop();
                break;

            case 3:
                peek();
                break;

            case 4:
                display();
                break;

            case 5:
                printf("\nExiting Course Registration Conflict Resolver...\n");
                break;

            default:
                printf("\nInvalid choice. Please try again.\n");
        }

    } while (choice != 5);

    return 0;
}