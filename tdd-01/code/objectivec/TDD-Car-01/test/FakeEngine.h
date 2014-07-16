//
//  FakeEngine.h
//  TDD-Car-01
//
//  Copyright (c) 2014 Company. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "../Engine.h"

@interface FakeEngine : Engine
{
    NSString* sound;
}

- (id)initWithSound:(NSString*)sound;
- (bool) isStartCalled;

@end
