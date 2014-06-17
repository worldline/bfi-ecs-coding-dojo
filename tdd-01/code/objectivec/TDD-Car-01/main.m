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
void assertTrue(bool condition, NSString* message);

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
    assertTrue([sound isEqualTo:@"vrooom"], @"Engine should start");
}

void should_start_car_INTEGRATION() {
    Engine *engine = [[Engine alloc] init];
    Car *car = [[Car alloc]initWithEngine:engine];
    
    NSString *sound = [car start];
    assertTrue([sound isEqualTo:@"vrooom"], @"Car and its engine should start");
}

void assertTrue(bool condition, NSString* message) {
    if (condition) {
        NSLog([NSString stringWithFormat:@"%@ : SUCCESS", message]);
    } else {
        NSLog([NSString stringWithFormat:@"%@ : FAIL", message]);
    }
}
