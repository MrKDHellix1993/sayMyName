/* tslint:disable */
// Generated using typescript-generator version 2.1.410 on 2020-03-05 23:59:35.

declare namespace Cvt {

    interface CoronaVirsuStatSummay {
        totalNewCasesOverGlob: number;
        prevDffNewRegCasesOverGlob: number;
        allLocationStats: LocationStats[];
    }

    interface LocationStats {
        state: string;
        country: string;
        newCasesFromPreviousDate: string;
        latestToltCases: string;
    }

}
