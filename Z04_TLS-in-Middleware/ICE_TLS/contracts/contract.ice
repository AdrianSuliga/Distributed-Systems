#ifndef CONTRACT_ICE
#define CONTRACT_ICE

module Contract
{
    interface Calculator
    {
        idempotent long add(int a, int b);
    };
};

#endif
