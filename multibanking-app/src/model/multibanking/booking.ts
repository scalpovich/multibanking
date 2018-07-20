/**
 * Multibanking REST Api
 * Use a bank code (blz) ending with X00 000 00 like 300 000 00 to run aggainst the mock backend. Find the mock backend at ${hostname}:10010
 *
 * OpenAPI spec version: 4.1.2-SNAPSHOT
 * Contact: age@adorsys.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { BankAccount } from './bankAccount';
import { BookingCategory } from './bookingCategory';


/**
 * Single bank booking
 */
export interface Booking {
    accountId?: string;
    /**
     * Additional transaction information
     */
    additional?: string;
    addkey?: string;
    /**
     * Target amount
     */
    amount?: number;
    /**
     * Account balance after this booking
     */
    balance?: number;
    /**
     * Origin of this booking
     */
    bankApi?: Booking.BankApiEnum;
    /**
     * Category of this booking
     */
    bookingCategory?: BookingCategory;
    /**
     * Booking date
     */
    bookingDate?: string;
    /**
     * Charge value
     */
    chargeValue?: number;
    /**
     * Creditor ID
     */
    creditorId?: string;
    /**
     * Reference of the opposite party
     */
    customerRef?: string;
    /**
     * External ID of this booking
     */
    externalId: string;
    id?: string;
    /**
     * Reference of the corresponding institution
     */
    instRef?: string;
    /**
     * Reference for the SEPA mandate
     */
    mandateReference?: string;
    /**
     * Original value
     */
    origValue?: number;
    /**
     * Opposite bank account
     */
    otherAccount?: BankAccount;
    /**
     * Primanota
     */
    primanota?: string;
    /**
     * Does this reverses a preexisting booking
     */
    reversal?: boolean;
    /**
     * Is this a SEPA transaction
     */
    sepa?: boolean;
    /**
     * Is this a standing order transaction
     */
    standingOrder?: boolean;
    /**
     * Transaction information
     */
    text?: string;
    /**
     * Transaction type as DTA Tx Key code
     */
    transactionCode?: string;
    /**
     * Usage of this transaction
     */
    usage?: string;
    userId?: string;
    /**
     * Date on which the transaction gets effective
     */
    valutaDate?: string;
}
export namespace Booking {
    export type BankApiEnum = 'HBCI' | 'FIGO' | 'FINAPI' | 'MOCK' | 'FIGO_ALTERNATIVE' | 'SCREEN_SCRAPPING';
    export const BankApiEnum = {
        HBCI: 'HBCI' as BankApiEnum,
        FIGO: 'FIGO' as BankApiEnum,
        FINAPI: 'FINAPI' as BankApiEnum,
        MOCK: 'MOCK' as BankApiEnum,
        FIGOALTERNATIVE: 'FIGO_ALTERNATIVE' as BankApiEnum,
        SCREENSCRAPPING: 'SCREEN_SCRAPPING' as BankApiEnum
    }
}