//
//  Car.h
//  TDD-Car-01
//
//  Created by AWL_02 on 16/06/2014.
//  Copyright (c) 2014 Company. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Engine.h"

@interface Car : NSObject
{
    Engine* engine;
}

- (id)initWithEngine:(Engine*)engine;
- (NSString*) start;

@end
