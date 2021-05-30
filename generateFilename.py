
'''
Генерирует из входящей строки файл

XXXX_MatrixDiagonalSum.swift
'''

import sys
import os

def get_filename(name):
    filename = name.split(". ")
    left = filename[0]
    right = filename[1]
    right = right.split()

    filename = left + "_" + "".join(right) + ".swift"

    return filename

'''
| XXX |
[TASK NAME](TASK LINK) |
[Swift](https://github.com/AlexMitcul/leetcode/blob/master/algorithms/FILENAME) |
GRADE |
'''

def add_line_to_readme(link, name, grade):
    filename = get_filename(name)
    number = name.split(".")[0]
    name = name.split(". ")[1]

    line = "\n| {} | [{}]({}) | [Swift](https://github.com/AlexMitcul/leetcode/blob/master/algorithms/{}) | {} |".format(number, name, link, filename, grade)

    with open("README.md", 'a') as f:
        f.write(line)
        
    

if __name__ == "__main__":
    name = input()
    link = input()
    grade = input()
    

    filename = "algorithms/" + get_filename(name)
    open(filename, 'w').close()
    os.system("open " + filename)

    add_line_to_readme(link, name, grade)