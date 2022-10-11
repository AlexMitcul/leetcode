#include <stdbool.h>

bool isSubsequence(char * s, char * t)
{
    while (*t) {
        if (*t == *s)
            s++;
        t++;
    }
    return (*s == '\0');
}
