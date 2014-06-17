//
//  main.m
//  TDD-Car-01
//
//  Created by AWL_02 on 16/06/2014.
//  Copyright (c) 2014 Company. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "model/Engine.h"
#import "model/Car.h"

void should_start_engine();
void should_start_car_INTEGRATION();

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        
        // insert code here...
        NSLog(@"Hello, World!");
        
        // Step 1
        should_start_engine();
        
        // Step2
        should_start_car_INTEGRATION();
        
    }
    return 0;
}

void should_start_engine() {
    Engine *engine = [[Engine alloc] init];
    NSString *sound = [engine start];
    if ([sound isEqualTo:@"vrooom"]) {
        NSLog(@"Engine starts with success");
    } else {
        NSLog(@"Engine failed at start");
    }
}

void should_start_car_INTEGRATION() {
    Engine *engine = [[Engine alloc] init];
    Car *car = [[Car alloc]initWithEngine:engine];
    
    NSString *carsound = [car start];
    if ([carsound isEqualTo:@"vrooom"]) {
        NSLog(@"Car and its engine start with success");
    } else {
        NSLog(@"Car and its engine failed at start");
    }
}
