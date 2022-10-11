
#include <stdbool.h>
// typedef unsigned char bool;
// static const bool False = 0;
// static const bool True = 1;

bool isSubsequence(char * s, char * t)
{
    while (*t) {
        if (*t == *s)
            s++;
        t++;
    }
    return (*s == '\0');
}
