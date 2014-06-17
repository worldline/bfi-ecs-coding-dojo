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

int main(int argc, const char * argv[])
{
    @autoreleasepool {
        
        // insert code here...
        NSLog(@"Hello, World!");
        
        // Step 1
        Engine *engine = [[Engine alloc] init];
        NSString *sound = [engine start];
        if ([sound isEqualTo:@"vrooom"]) {
            NSLog(@"Success");
        } else {
            NSLog(@"Failed");
        }
        
        // Step2
        Car *car = [[Car alloc]initWithEngine:engine];
        
        NSString *carsound = [car start];
        if ([carsound isEqualTo:@"vrooom"]) {
            NSLog(@"Success");
        } else {
            NSLog(@"Failed");
        }
        
    }
    return 0;
}

