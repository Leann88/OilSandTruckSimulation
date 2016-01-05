Objective
	The objective is to create model and simulate the oil sand mining as described above. The simulation will be coded and performed in Java and used to demonstrate the current access of shared resources. These simulations will then be used optimize the operations of the oil sand mine as well as determine the viable of additional trucks.

Definition of Situation
	According to the assignment details, the company initially has 8 trucks, 2 shovels and 2 treatment plants. The distance between the shovels and the treatment plants are 20 +/- 5 minutes and 40 +/- 10 minutes. There is also a 10 +/- 5 minute loading time for each shovel. The trucks must travel to and from their assigned shovel and wait their turn to use it. Once the trucks have been filled they return to the treatment plant to be unloaded. However, once a treatment plant has received 5 truckloads it will begin treating the oil sands. This process takes approximately an hour and during this time it will be unable to unload any incoming trucks. This process continues for 24 hours every day of the week.

Parameters of Situation
The following table lists the activities performed by each of the objects relevant to the situation described in the assignment as well as the time to perform each task.
Object
Travel time
(minutes)
Loading time (minutes)
Unloading Time
(minutes)
Treatment Time
Shovel 1
20.0 ± 5.0
10.0 ± 5.0
---
---
Shovel 2
40.0 ± 10.0
10.0 ± 5.0
---
---
Treatment Plant 1
Dependent
---
Negligible
60.0 ± 10.0
Treatment Plant 2
Dependent
---
Negligible
60.0 ± 10.0

Task 1 and 2: Construction of Simulations
	Prior to starting coding the diagram below was created to model the situation. As illustrated in the diagram, the trucks follow an almost circular loop. They begin and end at the treatment facility, going to their designated shovels and returning to drop off their load. It was assumed that there would be a queue at each shovel that would operate in a first-in-first-out manner. Once returning to the treatment facility, the trucks would be assigned to drop of their load at one of the two plants. 
Two possible methods of assignment were implemented and tested to determine which would be more efficient. The first method is based on what the previous truck as assigned. To expand, if the previous truck was assigned to treatment plant 1 then the next would be assigned to treatment plant 2. This is similar to is the previous truck was assigned to plant 2, however the next truck would be assigned plant 1. It was designed this was to ensure both plants are receiving loads so both would be able to begin the treatment process as fast as possible. The second method implemented involves assigning every 5 arriving trucks to one plant then the next 5 truck to the other plant over and over again. For example, the first 5 trucks would be assigned plant 1, the next 5 would be assigned plant 2 and the following 5 would be assigned plant 1. Like the previous method, this one is a cycle. Once the treatment plants began the treatment process, a queue of trucks would form. The queue would be once again a FIFO queue so that once the plant is done treating the loads the first truck in line would be able to drop off their load.


	In order to code the objects and simulations the intuitive approach was used. The threads, specifically the truck and treatment plant threads, were put to sleep in order to simulate their real world actions. These actions include travelling to and from the treatment facility, loading up with cargo and treating the 5 loads of oil sands. Semaphores were used to create the FIFO queues and determine the wait times. A semaphore table for the shovel was used to control which truck was currently using it and which truck was next. The time the truck called P() method and had to wait for the V() method was added to find wait times. The treatment plants semaphore was slightly modified so that it allowed 5 calls to the P() method prior to activating the wait method. The value was also made to reset to 5 instead of 1. This used because the treatment plant accepts 5 loads of oil sand before it starts the treatment process.
	To try and facilitate the times described in the parameter sections random number generators were used. Each shovel was given there loading and transportation times as well as the time value each varies. Every time a truck would call either a loading or transportation time a random number would be returned. The transportation or loading time would be added or subtracted by a random number multiplied variable time value. Addition and subtraction was determined by a random number generator multiplied by 2. The returned value corresponded to how long a thread was required to sleep.
	Two different simulation and main classes were constructed. The first simulation and main classes are related and used to simulation 8 trucks, 4 assigned to each shovel. The other two classes correspond to the situation used with 10 trucks and used to determine the best allocation of the 2 additional trucks. Both simulation classes have methods that count things such as total number of loads retrieved, total wait time and specific shovels and total time. The main classes were used to find things such as the average number of loads and standard deviation values of several simulations.
	Several key notes, since the parameters illustrate that the each task requires a certain number of minutes 100ms runtime is equivalent to 1 minute. This was needed or each simulation would take literal hours to complete. Each simulation was allowed to run for 60000ms which would be equivalent to 10 hours. This number was chosen because ensured each simulation did not run for an extended period of time but enough data would be recorded. 

Assumptions
•	A shovel can only be used by a single truck as once
•	No loads can be delivered to the treatment plant while a treatment is because processed
•	Five loads of untreated cargo is equivalent to 1 load of treated oil sand
•	A truck can deliver to either plant
•	Trucks initially begin at the treatment facility

Classes Made and Description
•	MainFirstSimulation: Runs multiple simulations of the original situation described in the assignment sheet and calculates various statistic using the simulations run.
•	Simulation: The actual simulation of the eight trucks.
•	MainSimulation2: Runs multiple simulations of the modified situation described in the assignment sheet and calculates various statistic using the simulations run.
•	Simulation: The actual simulation of the ten trucks.
•	SemShovel: Semaphore table used to control which truck can use the shovel, creating a FIFO queue
•	SemTreatmentPlant: Semaphore table used to control when the treatment plant begins the treatment process and create a FIFO queue for trucks waiting to deliver
•	Shovel: The actual shovel objects, used to determine travel time and loading time
•	TreatmentFacility: Assigns which treatment plant a truck can go to
•	TreatmentPlant: The object representing the treatment plants
•	Truck: The object representing the trucks


Simulation Results
The following two simulation are for the original situation described, 8 trucks, 4 assigned to each shovel. Each simulation uses a different method to assign the truck a treatment plant when they arrive:
Method 1: Alternating Every 1 Truck
MainSimulation 1
Simulation 1
Total Shovel Wait Time: 186.77min
Total Unloading Wait Time: 1002.66min
Total Number of loads unloaded: 33
Total Number of Treated Loads of 5: 6
Total time: 60009

Simulation 2
Total Shovel Wait Time: 183.78min
Total Unloading Wait Time: 875.78min
Total Number of loads unloaded: 34
Total Number of Treated Loads of 5: 6
Total time: 60004

Simulation 3
Total Shovel Wait Time: 147.17min
Total Unloading Wait Time: 964.91min
Total Number of loads unloaded: 34
Total Number of Treated Loads of 5: 6
Total time: 60004

Simulation 4
Total Shovel Wait Time: 135.23min
Total Unloading Wait Time: 858.55min
Total Number of loads unloaded: 38
Total Number of Treated Loads of 5: 6
Total time: 60004

Average number of Loads: 3.4749999999999996 per hour
Standard deviation of Load: 0.22173557826083448
Standard error of Load: 0.11086778913041724

Average Treatment of 5 loads: 0.6 per hour
Standard deviation of Treatment: 0.0
Standard error of Treatment: 0.0

Average wait time at shovel 1: 0.07306550747863247 hours
Average wait time at shovel 2: 0.05697476851851852 hours
Average wait time at Treatment Plant: 0.4463124941364105 hours

Method 2: Alternating Every 5 Trucks

MainSimulation 1
Simulation 1
Total Shovel Wait Time: 106.34min
Total Unloading Wait Time: 1175.59min
Total Number of loads unloaded: 36
Total Number of Treated Loads of 5: 7
Total time: 60014

Simulation 2
Total Shovel Wait Time: 119.56min
Total Unloading Wait Time: 925.11min
Total Number of loads unloaded: 33
Total Number of Treated Loads of 5: 6
Total time: 60004

Simulation 3
Total Shovel Wait Time: 165.6min
Total Unloading Wait Time: 759.89min
Total Number of loads unloaded: 35
Total Number of Treated Loads of 5: 7
Total time: 60005

Simulation 4
Total Shovel Wait Time: 90.95min
Total Unloading Wait Time: 1029.9min
Total Number of loads unloaded: 28
Total Number of Treated Loads of 5: 5
Total time: 60004


Average number of Loads: 3.3 per hour
Standard deviation of Load: 0.3559026084010438
Standard error of Load: 0.1779513042005219

Average Treatment of 5 loads: 0.625 per hour
Standard deviation of Treatment: 0.09574271077563379
Standard error of Treatment: 0.047871355387816894

Average wait time at shovel 1: 0.06836121031746031 hours
Average wait time at shovel 2: 0.03758665935672515 hours
Average wait time at Treatment Plant: 0.4965924993987494 hours








The following 3 simulations correspond the modified situation of having 10 trucks instead of the original 8:
MainSimulation 2: 1 Trucks added to each shovel
Simulation 1
Total Shovel Wait Time: 181.29min
Total Unloading Wait Time: 847.08min
Total Number of loads unloaded: 37
Total Number of Treated Loads of 5: 6
Total time: 60009

Simulation 2
Total Shovel Wait Time: 108.2min
Total Unloading Wait Time: 1043.6min
Total Number of loads unloaded: 32
Total Number of Treated Loads of 5: 6
Total time: 60005

Simulation 3
Total Shovel Wait Time: 178.89min
Total Unloading Wait Time: 1050.31min
Total Number of loads unloaded: 34
Total Number of Treated Loads of 5: 6
Total time: 60004

Simulation 4
Total Shovel Wait Time: 140.7min
Total Unloading Wait Time: 810.38min
Total Number of loads unloaded: 39
Total Number of Treated Loads of 5: 7
Total time: 60005


Average number of Loads: 3.5500000000000003 per hour
Standard deviation of Load: 0.31091263510296047
Standard error of Load: 0.15545631755148023

Average Treatment of 5 loads: 0.625 per hour
Standard deviation of Treatment: 0.04999999999999999
Standard error of Treatment: 0.024999999999999994

Average wait time at shovel 1: 0.058361424825174826 hours
Average wait time at shovel 2: 0.06568934629772961 hours
Average wait time at Treatment Plant: 0.44657082917193214 hours






MainSimulation 2: 2 Trucks added to shovel 1
Simulation 1
Total Shovel Wait Time: 146.6min
Total Unloading Wait Time: 858.58min
Total Number of loads unloaded: 39
Total Number of Treated Loads of 5: 7
Total time: 60009

Simulation 2
Total Shovel Wait Time: 166.49min
Total Unloading Wait Time: 997.05min
Total Number of loads unloaded: 37
Total Number of Treated Loads of 5: 6
Total time: 60005

Simulation 3
Total Shovel Wait Time: 131.87min
Total Unloading Wait Time: 848.61min
Total Number of loads unloaded: 38
Total Number of Treated Loads of 5: 6
Total time: 60004

Simulation 4
Total Shovel Wait Time: 187.86min
Total Unloading Wait Time: 731.47min
Total Number of loads unloaded: 36
Total Number of Treated Loads of 5: 6
Total time: 60005


Average number of Loads: 3.7499999999999996 per hour
Standard deviation of Load: 0.12909944487358044
Standard error of Load: 0.06454972243679022

Average Treatment of 5 loads: 0.625 per hour
Standard deviation of Treatment: 0.04999999999999999
Standard error of Treatment: 0.024999999999999994

Average wait time at shovel 1: 0.06155571905617195 hours
Average wait time at shovel 2: 0.06125285463966288 hours
Average wait time at Treatment Plant: 0.3817192596189307 hours








MainSimulation 2: 2 Trucks added to shovel 2
Simulation 1
Total Shovel Wait Time: 167.19min
Total Unloading Wait Time: 865.08min
Total Number of loads unloaded: 37
Total Number of Treated Loads of 5: 6
Total time: 60008

Simulation 2
Total Shovel Wait Time: 170.55min
Total Unloading Wait Time: 853.79min
Total Number of loads unloaded: 39
Total Number of Treated Loads of 5: 7
Total time: 60005

Simulation 3
Total Shovel Wait Time: 125.91min
Total Unloading Wait Time: 947.0min
Total Number of loads unloaded: 34
Total Number of Treated Loads of 5: 6
Total time: 60004

Simulation 4
Total Shovel Wait Time: 223.65min
Total Unloading Wait Time: 996.09min
Total Number of loads unloaded: 35
Total Number of Treated Loads of 5: 6
Total time: 60005


Average number of Loads: 3.625 per hour
Standard deviation of Load: 0.2217355782608345
Standard error of Load: 0.11086778913041725

Average Treatment of 5 loads: 0.625 per hour
Standard deviation of Treatment: 0.04999999999999999
Standard error of Treatment: 0.024999999999999994

Average wait time at shovel 1: 0.06735630434782608 hours
Average wait time at shovel 2: 0.0653172149122807 hours
Average wait time at Treatment Plant: 0.42327186368656955 hours



