# Bases
This Java program calculates the maximum number of bases that can fit within a 90-degree sector. It includes two versions of the algorithm to accomplish this task: `maxBasesInSectorV1` and `maxBasesInSectorV2`.

* The `Base` class stores the base's coordinates, converted into degrees taking minutes into account.
* The `maxBasesInSectorV1` method iterates through all possible sectors, shifting by 1 degree, and counts the number of bases within each sector. This is done by checking each base to see if it falls within the current 90-degree sector.
* The `maxBasesInSectorV2` method uses a simpler approach, checking only the angle between the base starting point and each target base, without iterating through all possible sectors.
* Both methods utilize a timing system to assess performance.
* The `main` method main reads base data from the file `in.txt`, creates a list of `Base` objects, and then calls both methods to determine the maximum number of bases in a sector.
